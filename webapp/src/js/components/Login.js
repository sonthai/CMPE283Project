import React from "react";
import NavLink from './NavLink';
import { browserHistory } from 'react-router';

export default class Login extends React.Component {

    constructor() {
        super();
        this.state = {
            status: ''
        };
    }
    login(e, status) {


        /*if (status == 0) {
            alert("Login successful " + status);

        } else {
            alert("Login failed " + status);
        }*/

    }
    handleChange(e) {
        this.setState({status: e.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();
        const userName = event.target.elements[0].value;
        const repo = event.target.elements[1].value;
        const path = `/dashboard`;
        alert(path);
        browserHistory.push(path);
    }
    render() {
        return (
            <div>
                <h2>Login</h2>
                <form onSubmit={this.handleSubmit}>
                    User name: <input type="text" placeholder="userName"/><br/>
                    Password: <input type="text" placeholder="password"/><br/>
                    <button className="btn btn-primary" type="submit">Go</button>
                </form>
                <input type="text" onChange={this.handleChange.bind(this)}/><br/>
                <div onClick={this.login.bind(this, this.state.status)} className="btn btn-primary">
                    Click me
                </div>
            </div>
        );
    }

}
