package salvomercurio.NewrizonWebsite2.auth;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import salvomercurio.NewrizonWebsite2.entities.User;
import salvomercurio.NewrizonWebsite2.exceptions.NotFoundException;
import salvomercurio.NewrizonWebsite2.exceptions.UnauthorizedException;
import salvomercurio.NewrizonWebsite2.services.UsersService;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {
	@Autowired
	UsersService usersService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (!request.getMethod().equalsIgnoreCase("OPTIONS")) {
			String authHeader = request.getHeader("Authorization");

			if (authHeader == null || !authHeader.startsWith("Bearer "))
				throw new UnauthorizedException("Please add token to authorization header");

			String accessToken = authHeader.substring(7);

			JWTTools.isTokenValid(accessToken);

			String email = JWTTools.extractSubject(accessToken);

			try {
				User user = usersService.findByEmail(email);

				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null,
						user.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authToken);

				filterChain.doFilter(request, response);
			} catch (NotFoundException e) {

				e.printStackTrace();
			}
		} else {
			filterChain.doFilter(request, response);
		}

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		return new AntPathMatcher().match("/auth/**", request.getServletPath());
	}

}
