import React, { useState } from "react";
import { Form, Button, Container } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { getUserDataAction, loginAction } from "../redux/actions";

const LoginPage = () => {
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const token = useSelector(state => state.auth.token);
    const userCurrent = useSelector(state => state.auth.userData)

    useEffect(() => {
      if(token){
      dispatch(getUserDataAction());
      }
      
    }, [token]);

    useEffect(() => {
      if(userCurrent){
      navigate("/");
      }
      
    }, [userCurrent]);
  
    const handleSubmit = (e) => {
      e.preventDefault();
      console.log("Submitted:", { email, password });
      const body = { email, password };
      dispatch(loginAction(JSON.stringify(body)));
      
      // window.location.reload();
    };
    
    return (
      <Container className="m-auto" style={{ background: "linear-gradient(orange, yellow)" }}>
      <Form onSubmit={handleSubmit} style={{ height: "70vh" }}>
        <h2>Login</h2>
        <Form.Group controlId="formEmail">
          <Form.Label>Email</Form.Label>
          <Form.Control
            type="email"
            className="p-3 text-white border border-dark bg-transparent opacity-0.05"
            placeholder="Enter your email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </Form.Group>
        <br></br>
        <br></br>
        <Form.Group controlId="formPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control
            type="password"
            className="p-3 text-white border border-dark bg-transparent opacity-0.05"
            placeholder="Enter your password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </Form.Group>
        <br></br>
        <br></br>
  
        <Button className=" bg-transparent p-2 mb-2 border border-dark text-dark" type="submit">
          LOG IN
        </Button>
        <Link to="/register">
          <Button className=" bg-transparent p-2 mb-2 border border-dark text-dark">Register</Button>
        </Link>
      </Form>
      </Container>
    );
  };
  
  export default LoginPage;