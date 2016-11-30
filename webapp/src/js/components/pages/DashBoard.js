import React from 'react';
import { Link } from 'react-router';
export default class Dashboard extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data: []
        };
    }

    componentWillMount () {
        fetch('http://services.groupkt.com/state/get/IND/all')
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
    }

    render() {
        return (
            <div>
                <Link to="dashboard"><button disabled="true" className="btn btn-success">DashBoard</button></Link>
                <Link to="project"><button className="btn">Project</button></Link>
                <Link to="profile"><button className="btn btn-success">Profile</button></Link>
                <h1>Dashboard</h1>
                <table className="table">
                    <thead>
                      <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                      </tr>
                    </thead>
                    <tbody>
                        {this.state.data}}
                    </tbody>
                 </table>
            </div>
        );
    }
}