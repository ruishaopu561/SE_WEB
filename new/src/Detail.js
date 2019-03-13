import React, { Component } from 'react';
import pic from './image/3.jpeg';

class Detail extends Component {
    constructor(){
        super(...arguments);
        this.state={
            hover: false,
        }
        this.onMouseEnter = this.onMouseEnter.bind(this);
        this.onMouseLeave = this.onMouseLeave.bind(this);
    }

    onMouseEnter(){
        this.setState({
            hover:true,
        })
    }

    onMouseLeave(){
        this.setState({
            hover:false,
        })
    }

    render(){
        return(
            <div className="introduce">
                <div className="show">
                    <img className="sample" src={pic} alt="Sample"/>
                    <br/>
                    name:<p className="book-name">xxxx</p>
                    <br/>
                    price:$xxx
                </div>
                <div className="inputText">
                    <input className="text" value="Introduction"/>
                </div>
            </div>
        )
    }
}

export default Detail;