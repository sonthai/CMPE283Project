import React from 'react';
import { Link } from 'react-router';
import styles from './../../styles/dashboard.css'
export default class Dashboard extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data: []
        };
    }

    componentWillMount () {
        /*fetch('http://services.groupkt.com/state/get/IND/all')
                    .then((response) => {
                        return response.json() })
                            .then((json) => {
                            console.log(JSON.stringify(json['RestResponse']['result'][0]));
                                var d = json['RestResponse']['result'];
                                var res = [];
                                console.log('Length ' + d.length);
                                for(var i = 0; i < d.length; i++) {
                                    var row = d[i];
                                    var keyVal =  i;
                                    //console.log('Row value ' + row['name']);
                                    res.push(<tr key={keyVal}><td>{row['name']}</td><td>{row['country']}</td><td>{row['area']}</td></tr>);
                                }
                                console.log(res[0]);
                                this.setState({data: res});

                            });
                            */
        fetch('http://localhost:8080/instance/list', {
		'Access-Control-Allow-Origin': '*'
	})
            .then((response) => {
                console.log(response);
                return response;
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
                                            <div className="huge">140</div>
                                            <div>Hours billed</div>
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
                                            <div className="huge">5</div>
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
                                           <div className="huge">8</div>
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
                                           <div className="huge">$153.03</div>
                                           <div>Billed for December</div>
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
                                    <th>Cost</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr className="even gradeC">
                                    <td>iOS #1</td>
                                    <td>3 hours</td>
                                    <td>$0.3</td>
                                    <td className="center"><button type="button" className="btn btn-info btn-xs">Reserve</button>
                                    <button type="button" className="btn btn-info btn-xs">Release</button>
                                    <button type="button" className="btn btn-info btn-xs">Suspend</button>
                                    <button type="button" className="btn btn-info btn-xs">Resume</button>
                                    </td>
                                </tr>
                                <tr className="even gradeC">
                                    <td>iOS #2</td>
                                    <td>30 hours</td>
                                    <td>$3</td>
                                    <td className="center"><button type="button" className="btn btn-info btn-xs">Reserve</button>
                                    <button type="button" className="btn btn-info btn-xs">Release</button>
                                    <button type="button" className="btn btn-info btn-xs">Suspend</button>
                                    <button type="button" className="btn btn-info btn-xs">Resume</button>
                                    </td>
                                </tr>
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
