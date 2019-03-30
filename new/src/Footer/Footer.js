import React, { Component } from 'react';
import './footer.css';

class Footer extends Component {
    render(){
        return(
            <div>
                <p>
                   {this.props.children}
                </p>
            </div>
        )
    }
}

export default Footer;