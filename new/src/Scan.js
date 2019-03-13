import React, { Component } from 'react';
import './App.css';
import pic from './image/3.jpeg';

class Scan extends Component {
    render(){
        return (
            <div className="scan">
                <div>
                    <input className="search" type="search" value="ebook"/>
                </div>
                <div className="sug">
                    <p>重点推荐>>></p><br/>
                    <div className="note">
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                    </div>
                </div>
                <div className="book">
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                        <div className="sam"><img src={pic} alt="Sample"/></div>
                </div>
                <div className="sea">
                    <div>
                        <p>热门搜索>>></p>
                        <br/>
                        <table>
                            <tr><td>Age</td></tr>
                            <tr><td>Age</td></tr>
                            <tr><td>Age</td></tr>
                            <tr><td>Age</td></tr>
                            <tr><td>Age</td></tr>
                            <tr><td>Age</td></tr>
                            <tr><td>Age</td></tr>
                            <tr><td>Age</td></tr>
                            <tr><td>Age</td></tr>
                            <tr><td>Age</td></tr>
                        </table>
                    </div>
                    <br/>
                    <div>
                        <p>畅销排行榜>>></p>
                        {/* <br/> */}
                        <div className="sug">
                            <div className="sam"><img src={pic} alt="Sample"/></div>
                            <div className="sam"><img src={pic} alt="Sample"/></div>
                            <div className="sam"><img src={pic} alt="Sample"/></div>
                            <div className="sam"><img src={pic} alt="Sample"/></div>
                            <div className="sam"><img src={pic} alt="Sample"/></div>
                            <div className="sam"><img src={pic} alt="Sample"/></div>
                            <div className="sam"><img src={pic} alt="Sample"/></div>
                            <div className="sam"><img src={pic} alt="Sample"/></div>
                            <div className="sam"><img src={pic} alt="Sample"/></div>
                            <div className="sam"><img src={pic} alt="Sample"/></div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Scan;