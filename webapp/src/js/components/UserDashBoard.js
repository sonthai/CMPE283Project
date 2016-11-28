import React from 'react';
import { Link } from 'react-router';
import DashBoard from './pages/DashBoard';

class UserDashBoard extends React.Component {
    render() {
        return (
            <div>
                <Link to="dashboard"><button disable="true" className="btn btn-success">DashBoard</button></Link>
                <Link to="project"><button className="btn">Project</button></Link>
                <Link to="profile"><button className="btn btn-success">Profile</button></Link>
                <DashBoard />
            </div>

        );
    }
}

export default UserDashBoard;