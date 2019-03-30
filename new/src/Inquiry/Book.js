import React, { Component } from 'react';
import './inquiry.css';

class Book extends Component {
    render(){
        return (
            <div>
                <table className="ui-jqgrid-htable" role="grid" aria-labelledby="gbox_tabGrid" cellspacing="0" cellpadding="0" border="0">
                    <thead>
                        <tr className="ui-jqgrid-labels ui-sortable" role="rowheader">
                            <th id="tabGrid_cb" role="columnheader" className="ui-th-ltr">
                                <div id="jqgh_tabGrid_cb">
                                    <span className="s-ico">
                                        <span sort="asc" className="ui-grid-ico-so"></span>
                                        <span sort="desc" className="ui-icon-desc"></span>
                                    </span>
                                </div>
                            </th>
                            <th id="tabGrid_njmc" role="columnheader" className="ui-sortable-handle">
                                <div id="jqgh_tabGrid_njmc" className="ui-jqgrid-sortable">
                                    书名
                                    <span className="s-ico">
                                        <span sort="asc" className="ui-grid-ico-so"></span>
                                        <span sort="desc" className="ui-icon-desc"></span>
                                    </span>
                                </div>
                            </th>
                            <th id="tabGrid_zyh" role="columnheader" className="ui-sortable-handle">
                                <div id="jqgh_tabGrid_zyh" className="ui-jqgrid-sortable">
                                    作者
                                    <span className="s-ico">
                                        <span sort="asc" className="ui-grid-ico-so"></span>
                                        <span sort="desc" className="ui-icon-desc"></span>
                                    </span>
                                </div>
                            </th>
                            <th id="tabGrid_zymc" role="columnheader" className="ui-sortable-handle">
                                <div id="jqgh_tabGrid_zymc" className="ui-jqgrid-sortable">
                                    语言
                                    <span className="s-ico">
                                        <span sort="asc" className="ui-grid-ico-so"></span>
                                        <span sort="desc" className="ui-icon-desc"></span>
                                    </span>
                                </div>
                            </th>
                            <th id="tabGrid_dlbs" role="columnheader" className="ui-sortable-handle">
                                <div id="jqgh_tabGrid_dlbs" className="ui-jqgrid-sortable">
                                    出版日期
                                    <span className="s-ico">
                                        <span sort="asc" className="ui-grid-ico-so"></span>
                                        <span sort="desc" className="ui-icon-desc"></span>
                                    </span>
                                </div>
                            </th>
                            <th id="tabGrid_rwbj" role="columnheader" className="ui-sortable-handle">
                                <div id="jqgh_tabGrid_rwbj" className="ui-jqgrid-sortable">
                                    价格
                                    <span className="s-ico">
                                        <span sort="asc" className="ui-grid-ico-so"></span>
                                        <span sort="desc" className="ui-icon-desc"></span>
                                    </span>
                                </div>
                            </th>
                        </tr>
                    </thead>
                </table>
            </div>
        )
    }
}

export default Book;