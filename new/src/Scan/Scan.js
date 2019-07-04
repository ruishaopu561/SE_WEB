import React, { Component } from 'react';
import pic from '../image/2.jpeg';
import './scan.css';

class Scan extends Component {
    render(){
        return (
            <div className="scan">
                <div id="quickly-search">
                    <p><input className="search_input" type="text" id="username" defaultValue="book name"/><button className="search_button">SEARCH</button></p>
                </div>
                <div className="highly-recommented">
                    <p className="word">重点推荐>>></p><br/>
                    <div className="recomment">
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
                <div className="container">
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
                <div className="right-part">
                    <div>
                        <p className="word">热门搜索>>></p>
                        <br/>
                        <table className="popular-searches">
                            <tr><td>1.xxxx</td></tr>
                            <tr><td>2.xxxx</td></tr>
                            <tr><td>3.xxxx</td></tr>
                            <tr><td>4.xxxx</td></tr>
                            <tr><td>5.xxxx</td></tr>
                            <tr><td>6.xxxx</td></tr>
                            <tr><td>7.xxxx</td></tr>
                            <tr><td>8.xxxx</td></tr>
                            <tr><td>9.xxxx</td></tr>
                            <tr><td>10.xxxx</td></tr>
                        </table>
                    </div>
                    <br/>
                    <div>
                        <p className="word">畅销排行榜>>></p>
                        <div className="best-seller-ranking">
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