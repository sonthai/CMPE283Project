import ReactDOM from 'react-dom';
import React from 'react';
import { Router, Route, IndexRoute, browserHistory } from 'react-router';
import Login from './components/Login';


import UserDashBoard from './components/UserDashBoard';

// Pages for user dashboard
import DashBoard from './components/pages/DashBoard';
import Error from './components/pages/Error';
import Project from './components/pages/Project';
import Profile from './components/pages/Profile';

const app = document.getElementById('app');

ReactDOM.render(
    <Router history={browserHistory}>
    	<Route path="/" component={Login} />
    	<Route path="error" component={Error}/>
    	<Route path="user" component={UserDashBoard}/>
    	<Route path="dashboard" component={DashBoard}/>
    	<Route path="project" component={Project} />
        <Route path="profile" component={Profile} />
    </Router>,
app);