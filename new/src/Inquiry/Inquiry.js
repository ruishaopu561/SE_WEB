import React, { Component } from 'react';
import './inquiry.css';

const bookName=[
    { value: "", label:"全部"},
    { value: "0", label:"大类"}
]

const publistionYear=[
    { value:"", label: "全部"},
    { value: "2010+", label: "2010以后"},
    { value: "2000~2010", label: "2000以后"},
    { value: "1970~2000", label: "1970以后"},
    { value: "1940~1970", label: "1940以后"},
    { value: "1900~1940", label: "1900以后"},
    { value: "1900-", label: "1900以前"}
]

const language=[
    { value: "", label: "全部"},
    { value: "中文", label: "中文"},
    { value: "美文", label: "美文"},
    { value: "英文", label: "英文"},
    { value: "德文", label: "德文"},
    { value: "法文", label: "法国"},
    { value: "其他", label: "其他"}
]

const writer=[
    { value: "", label: "全部"},
    { value: "", label: "东野圭吾"},
    { value: "", label: "鲁迅"}
]

const price=[
    { value: "", label: "全部"},
    { value: "50-", label: "50以下"},
    { value: "50-100", label: "50至100"},
    { value: "100-150", label: "100至150"},
    { value: "150-200", label: "150至200"},
    { value: "200+", label: "200以上"}
]

class Inquiry extends Component {
    render(){
        return (
            <div>
                {/* <div>
                    <form id="search_form" className="form" name="form" onsubmit="return false;" action="" method="post"  
                    // role="form"
                    >
                        <div className="row">
                            <div className="col-md-3 col-sm-6">
                                <div className="form-group">
                                    <label for="" className="col-sm-4 control-label">书名</label>
                                    <div className="col-sm-8">
                                        <select name="dl" id="dl" className="form-control" options={bookName}/>
                                        <div className="chosen-container" title="" id="dl_chosen">
                                            <p>
                                                <span>全部</span>
                                                <div><b></b></div>
                                            </p>
                                            <div className="chosen-drop">
                                                <div className="chosen-search">
                                                    <input type="text" autocomplete="off" name="autocomplete" readonly=""></input>
                                                    <ul className="chosen-results"></ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-3 col-sm-6">
                                <div className="form-group">
                                    <label for="" className="col-sm-4 control-label">语言</label>
                                    <div className="col-sm-8">
                                        <select name="nj_cx" id="nj_cx" className="form-control" options={language}/>
                                        <div className="chosen-container" title="" id="nj_cx_chosen">
                                            <p>
                                                <span>中文</span>
                                                <div><b></b></div>
                                            </p>
                                            <div className="chosen-drop">
                                                <div className="chosen-search">
                                                    <input type="text" autocomplete="off" name="autocomplete"></input>
                                                    <ul className="chosen-results"></ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-3 col-sm-6">
                                <div className="form-group">
                                    <label for="" className="col-sm-4 control-label">出版年份</label>
                                    <div className="col-sm-8">
                                        <select name="jg_id" id="jg_id" className="form-control" options={publistionYear}/>
                                        <div className="chosen-container" title="" id="jg_id_chosen">
                                            <p>
                                                <span>2010</span>
                                                <div><b></b></div>
                                            </p>
                                            <div className="chosen-drop">
                                                <div className="chosen-search">
                                                    <input type="text" autocomplete="off" name="autocomplete"></input>
                                                    <ul className="chosen-results"></ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div className="col-md-3 col-sm-6">
                                <div className="form-group">
                                    <label for="" className="col-sm-4 control-label">价格</label>
                                    <div className="col-sm-8">
                                        <select name="zyh_id_cx" id="zyh_id_cx" className="form-control" options={price}/>
                                        <div className="chosen-container" title="" id="zyh_id_cx_chosen">
                                            <p>
                                                <span>全部</span>
                                                <div><b></b></div>
                                            </p>
                                            <div className="chosen-drop">
                                                <div className="chosen-search">
                                                    <input type="text" autocomplete="off" name="autocomplete"></input>
                                                    <ul className="chosen-results"></ul>
                                                </div>
                                            </div>	
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div> */}
                <div>
                    <div>
                        <label>书名</label>
                        <select className="col" options={bookName}>书名</select>
                    </div>
                    <div>
                        <select className="col" options={publistionYear}>出版年份</select>
                    </div>
                    <div>
                        <select className="col" options={language}>语言</select>
                    </div>
                    <div>
                        <select className="col" options={writer}>作者</select>
                    </div>
                    <div>
                        <select className="col" options={price}>价格</select>
                    </div>
                </div>
                <div>
                    <p>
                        <button className="button">搜索</button>
                    </p>
                </div>
            </div>
        )
    }
}

export default Inquiry;