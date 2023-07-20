import { BrowserRouter, Route, Routes } from "react-router-dom";
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import NewrizonNavbar from './components/NewrizonNavbar';
import NewrizonFooter from './components/NewrizonFooter';
import NewrizonHomepage from "./components/NewrizonHomepage";
import ProductSpecs from './components/ProductSpecs';
import AccessoriesList from './components/AccessoriesList';
import LoginPage from './components/LoginPage';
import RegisterPage from './components/RegisterPage';
import Cart from './components/Cart';
import ProfilePage from './components/ProfilePage';

function App() {
  return (
    <div style={{ background: "linear-gradient(45deg, rgba(101,101,96) 0 25%, rgba(255,255,255) 25% 50%, rgba(230,238,17) 50% 75%, rgba(223,149,21) 75% 100%)" }}>
      <BrowserRouter>
        <NewrizonNavbar />
        <Routes>
        <Route path="/" element={<NewrizonHomepage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/profile/me" element={<ProfilePage />} />
        <Route path="/products/:productId" element={<ProductSpecs />} />
        <Route path="/products/accessories/:type" element={<AccessoriesList />} />
        <Route path="/cart" element={<Cart />} />
        </Routes>
        <NewrizonFooter />
      </BrowserRouter>
    </div>
  );
}

export default App;
