import React from 'react';
import { Link } from 'react-router';

export default class Profile extends React.Component {
    render() {
        return (
            <div>
                <Link to="dashboard"><button className="btn btn-success">DashBoard</button></Link>
                <Link to="project"><button className="btn">Project</button></Link>
                <Link to="profile"><button disabled="true" className="btn btn-success">Profile</button></Link>
                <h1>Profile</h1>
            </div>
        );
    }
}