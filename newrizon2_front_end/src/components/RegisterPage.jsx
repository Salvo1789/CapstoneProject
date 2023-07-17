import React, { useState } from "react";
import { Form, Button, Container } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { registerAction } from "../redux/actions";

const RegisterPage = () => {
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Submitted:", { name, surname, username, email, password });
    const body = {username, email, password, name, surname };
    dispatch(registerAction(JSON.stringify(body)));
    navigate("/");
  };

  return (
    <Container className="m-auto" style={{ background: "linear-gradient(orange, yellow)" }}>
    <Form onSubmit={handleSubmit}>
      <h2>Register</h2>
      <Form.Group controlId="formName">
        <Form.Label>Name</Form.Label>
        <Form.Control
          type="text"
          placeholder="Enter your name"
          value={name}
          className="p-3 text-white border border-dark bg-transparent opacity-0.05"
          onChange={(e) => setName(e.target.value)}
        />
      </Form.Group>
      <br></br>
      <br></br>
      <Form.Group controlId="formSurname">
        <Form.Label>Surname</Form.Label>
        <Form.Control
          type="text"
          placeholder="Enter your surname"
          value={surname}
          className="p-3 text-white border border-dark bg-transparent opacity-0.05"
          onChange={(e) => setSurname(e.target.value)}
        />
      </Form.Group>
      <br></br>
      <br></br>
      <Form.Group controlId="formUsername">
        <Form.Label>Username</Form.Label>
        <Form.Control
          type="text"
          placeholder="Enter your username"
          value={username}
          className="p-3 text-white border border-dark bg-transparent opacity-0.05"
          onChange={(e) => setUsername(e.target.value)}
        />
      </Form.Group>
      <br></br>
      <br></br>
      <Form.Group controlId="formEmail">
        <Form.Label>Email</Form.Label>
        <Form.Control
          type="email"
          placeholder="Enter your email"
          value={email}
          className="p-3 text-white border border-dark bg-transparent opacity-0.05"
          onChange={(e) => setEmail(e.target.value)}
        />
      </Form.Group>
      <br></br>
      <br></br>
      <Form.Group controlId="formPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control
          type="password"
          placeholder="Enter your password"
          value={password}
          className="p-3 text-white border border-dark bg-transparent opacity-0.05"
          onChange={(e) => setPassword(e.target.value)}
        />
      </Form.Group>
      <br></br>
      <br></br>
      <Button type="submit" className=" bg-transparent text-dark border border-dark">
        REGISTER
      </Button>
    </Form>
    </Container>
  );
};

export default RegisterPage;