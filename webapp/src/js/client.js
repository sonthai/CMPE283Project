import ReactDOM from 'react-dom';
import React from 'react';
import Greeting from './components/Greetings';

const app = document.getElementById('app');

ReactDOM.render(
    <Greeting name="World" />, 
    app
);
