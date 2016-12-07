import React from 'react';
import { Link } from 'react-router';
import styles from './../../styles/dashboard.css';
import InstanceRow from './InstanceRow'
export default class Dashboard extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data: [],
            activeInstances: '',
            numOfInstances: '',
            numOfHoursUsage: ''

        };
    }

    componentWillMount () {
        fetch('http://localhost:8080/instance/list?user=sdthai')
            .then((responses) => {
                return responses.json()
            })
            .then((json) => {
                var activeInstances =  json['data']['activeInstances'];
                var numOfInstances =  json['data']['numOfInstances'];
                var instances = json['data']['instances'];
                var numOfHoursUsage = 0;
                var row = [];
                instances.forEach(function(instance) {
                    row.push(<InstanceRow instance={instance} key={instance.uuid}/>);
                    numOfHoursUsage += instance.hourUsage;
                });
                this.setState({activeInstances: activeInstances, numOfInstances: numOfInstances,
                                data: row, numOfHoursUsage: numOfHoursUsage});
            });
    }

    render() {
        return (
            <div className="wrapper">
                <nav className="navbar navbar-default navbar-static-top no-margin-bottom" role="navigation">
                    <div className="navbar-header">
                        <button type="button" className="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span className="sr-only">Toggle navigation</span>
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                        </button>
                        <a className="navbar-brand" href="index.html">ZenWS - Logged in as "Test User"</a>
                    </div>

                    <div className="navbar-default sidebar" role="navigation">
                        <div className="sidebar-nav navbar-collapse">
                            <ul className="nav" id="side-menu">
                               <li>
                                <Link to="dashboard">Dashboard</Link>
                               </li>
                               <li>
                                <Link to="project">Project</Link>
                               </li>
                               <li>
                                <Link to="profile">Profile</Link>
                               </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <div id="page-wrapper">
                    <div className="row">
                        <div className="col-lg-12">
                            <h1 className="page-header">Dashboard</h1>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-lg-3 col-md-6">
                            <div className="panel panel-green">
                                <div className="panel-heading">
                                    <div className="row">
                                        <div className="col-xs-3">
                                            <i className="fa fa-tasks fa-5x"></i>
                                        </div>
                                        <div className="col-xs-9 text-right">
                                            <div className="huge">{this.state.numOfHoursUsage}</div>
                                            <div>Hours Usage</div>
                                        </div>
                                    </div>
                                 </div>
                             </div>
                        </div>
                        <div className="col-lg-3 col-md-6">
                            <div className="panel panel-primary">
                                <div className="panel-heading">
                                    <div className="row">
                                        <div className="col-xs-3">
                                            <i className="fa fa-eye fa-5x"></i>
                                        </div>
                                        <div className="col-xs-9 text-right">
                                            <div className="huge">{this.state.activeInstances}</div>
                                            <div>Active Instances</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="col-lg-3 col-md-6">
                           <div className="panel panel-yellow">
                               <div className="panel-heading">
                                   <div className="row">
                                       <div className="col-xs-3">
                                           <i className="fa fa-eye-slash fa-5x"></i>
                                       </div>
                                       <div className="col-xs-9 text-right">
                                           <div className="huge">{this.state.numOfInstances}</div>
                                           <div>All Instances</div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                       </div>
                       <div className="col-lg-3 col-md-6">
                           <div className="panel panel-red">
                               <div className="panel-heading">
                                   <div className="row">
                                       <div className="col-xs-3">
                                           <i className="fa fa-user fa-5x"></i>
                                       </div>
                                       <div className="col-xs-9 text-right">
                                           <div className="huge">$ 10</div>
                                           <div>Beginner Plan</div>
                                       </div>
                                   </div>
                               </div>
                               <a href="#"></a>
                           </div>
                       </div>
                    </div>
                    <div className="row">
                        <div className="col-lg-8">
                            <div className="panel panel-default non-display">
                                <div className="panel-heading">
                                    <i className="fa fa-bar-chart-o fa-fw"></i> Area Chart Example
                                </div>
                                <div className="panel-body">
                                    <div id="morris-area-chart"></div>
                                </div>
                            </div>
                            <div className="panel panel-default">
                                <div className="panel-heading">
                                    <i className="fa fa-bar-chart-o fa-fw"></i> All Instances / Active Instances
                                </div>
                                <div className="panel-body">
                                    <div className="row">
                                        <div className="col-lg-4"></div>
                                        <div className="col-lg-12">
                                            <div id="morris-bar-chart"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <div>
                    </div>
                    <div className="panel-body">
                        <table width="100%" className="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                                <tr>
                                    <th>Instance</th>
                                    <th>Usage</th>
                                    <th>Status</th>
                                    <th>Date Created</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.data}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        </div>
        );
    }
}
