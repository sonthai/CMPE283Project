import React from 'react';
import { Link } from 'react-router';
import DashBoard from './pages/DashBoard';
import styles from './../styles/customUI.css'

class UserDashBoard extends React.Component {
    render() {
        return (
            <div className="skin-black">
                <div className="wrapper row-offcanvas row-offcanvas-left">
                    <aside className="left-side sidebar-offcanvas">
                        <section className="sidebar">
                            <ul className="sidebar-menu">
                               <li>
                                <Link to="dashboard">Dashboard</Link>
                               </li>
                               <li>
                                <Link to="project">Project</Link>
                               </li>
                               <li>
                                <Link to="project">Profile</Link>
                               </li>

                            </ul>
                        </section>
                    </aside>

                 </div>
            </div>
        );
    }
}

export default UserDashBoard;
