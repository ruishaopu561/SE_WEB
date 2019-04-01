import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import pic from '../image/2.jpeg';
import './inquiry.css';

let counter = 0;
function createData(name, author, price, isbn, stock, img) {
	counter += 1;
	return { id: counter, name, author, price, isbn, stock, img };
}

class Inquiry extends Component {
	constructor(props) {
		super(props);
		this.state = {
			books: [
				createData('Harry Potter', ' J. K. Rowling', 3000, '‎978-3-16-148410-0', 5, './img/hp.jpg'),
				createData('King of the Ring', 'John Ronald Reuel Tolkien', 5000, '‎178-3-16-148410-0', 9, './img/ring.jpg'),
				createData('The Three-Body Problem', '	Liu Cixin', 4000, '‎278-3-16-148410-0', 7, './img/tb.jpg'),
			],
			booksCp: [
				createData('Harry Potter', ' J. K. Rowling', 3000, '‎978-3-16-148410-0', 5, './img/hp.jpg'),
				createData('King of the Ring', 'John Ronald Reuel Tolkien', 5000, '‎178-3-16-148410-0', 9, './img/ring.jpg'),
				createData('The Three-Body Problem', '	Liu Cixin', 4000, '‎278-3-16-148410-0', 7, './img/tb.jpg'),
			],
            selectValue1: "",
            inputValue1: "",
            inputValue2: "",
		};
	}
	handleLink(index) {
		return "/detail/" + index
	}

	handleChange() {
		let pattern = document.getElementById('filter').value
		let list = this.state.booksCp.filter((item) => {
			return item.name.indexOf(pattern) !== -1
		})
		this.setState({
			books: list
		})
    }
    
    handleSelectValue1(e){
        this.setState({selectValue1: e.target.value});
    }

    handleInputValue1(e){
        this.setState({inputValue1: e.target.value});
    }

    handleInputValue2(e){
        this.setState({inputValue2: e.target.value});
    }

	render() {
		return (
			<div>
				<div className="left-part">
                    <p className="word">重点推荐>>></p>
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
				<div className="paper">
					<form>
						<div>
							<label>作者</label>
							<input className="search_feild" id="filter" label="搜索框" onChange={() => this.handleChange()}/>
						</div>
						<div>
							<label>书名</label>
							<input className="search_feild" id="filter" label="搜索框" onChange={() => this.handleChange()}/>
						</div>
						<div>
							<button className="search" onClick={()=> this.handleChange()}>搜索</button>
						</div>
					</form>
					<table className="table">
					<thead>
						<tr>
                            <td></td>
							<td>
								<button className="btn_login">书名</button>
							</td>
							<td align="right">
								<button className="btn_login">作者</button>
							</td>
							<td align="right">
								<button className="btn_login">价格</button>
							</td>
							<td align="right">
								<button className="btn_login">ISBN</button>
							</td>
							<td align="right">
								<button className="btn_login">库存</button>
							</td>
						</tr>
					</thead>
					<tbody>
						{this.state.books.map((item, index) => {
							return (
								<tr key={index} >
                                    <td>
                                        <input type="checkbox" />
                                    </td>
									<td component="th">
										{item.name}
									</td>
									<td align="right">
										{item.author}
									</td>
									<td align="right">
										{item.price / 100}
									</td>
									<td align="right">
										{item.isbn}
									</td>
									<td align="right" >
										{item.stock}
									</td>
									<td align="right" >
										<Link to={this.handleLink(index)}>查看详情</Link>
									</td>
								</tr>
							)
                        })}
					</tbody>
                    <div>
                        <button className="addToShopCart">
                            <Link to='./Shopcart'>加入购物车</Link>
                        </button>
                    </div>
				</table>
				</div>
			</div>
		);
	}
}

export default Inquiry;



// class Inquiry extends Component {
//     constructor(){
//         super(...arguments);
//         this.state={
//             selectValue1: "2010+",
//             selectValue2: "Chinese",
//             selectValue3: "",
//             inputValue1: "",
//             inputValue2: "",
//             showTable: true
//         }
//     }

//     handleOnClick(){
//         this.setState({
//             showTable: !this.state.showTable
//         });
//         console.log(this.state.showTable)
//     }



//     handleSelectValue1(e){
//         this.setState({selectValue1: e.target.value});
//     }

//     handleSelectValue2(e){
//         this.setState({selectValue2: e.target.value});
//     }

//     handleSelectValue3(e){
//         this.setState({selectValue3: e.target.value});
//     }

//     handleInputValue1(e){
//         this.setState({inputValue1: e.target.value});
//     }

//     handleInputValue2(e){
//         this.setState({inputValue2: e.target.value});
//     }

//     render(){
//         return (
//             <div>
//                 <form>
//                     <div>
//                         <label>出版年份</label>
//                         <select className="col" value={this.state.selectValue1} onChange={this.handleSelectValue1.bind(this)}>
//                             <option value="" label= "全部"></option>
//                             <option value= "2010+" label= "2010以后"></option>
//                             <option value= "2000~2010" label= "2000以后"></option>
//                             <option value= "1970~2000" label= "1970以后"></option>
//                             <option value= "1940~1970" label= "1940以后"></option>
//                             <option value= "1900~1940" label= "1900以后"></option>
//                             <option value= "1900-" label= "1900以前"></option>
//                         </select>
//                     </div>
//                     <div>
//                         <label>语言</label>
//                         <select className="col" value={this.state.selectValue2} onChange={this.handleSelectValue2.bind(this)}>
//                             <option value= "" label= "全部"></option>
//                             <option value= "Chinese" label= "中文"></option>
//                             <option value= "American" label= "美文"></option>
//                             <option value= "English" label= "英文"></option>
//                             <option value= "German" label= "德文"></option>
//                             <option value= "French" label= "法国"></option>
//                             <option value= "others" label= "其他"></option>
//                         </select>
//                     </div>
//                     <div>
//                         <label>价格</label>
//                         <select className="col" value={this.state.selectValue3} onChange={this.handleSelectValue3.bind(this)}>
//                             <option value= "" label= "全部"></option>
//                             <option value= "50-" label= "50以下"></option>
//                             <option value= "50-100" label= "50至100"></option>
//                             <option value= "100-150" label= "100至150"></option>
//                             <option value= "150-200" label= "150至200"></option>
//                             <option value= "200+" label= "200以上"></option>
//                         </select>
//                     </div>
//                     <div>
//                         <label>作者</label>
//                         <input className="inquiry-input" type="text" value={this.state.inputValue1} onChange={this.handleInputValue1.bind(this)} autoComplete="on" maxLength="20"></input>
//                     </div>
//                     <div>
//                         <label>书名</label>
//                         <input className="inquiry-input" type="text" value={this.state.inputValue2} onChange={this.handleInputValue2.bind(this)} autoComplete="on" maxLength="20"></input>
//                     </div>
//                     <div>
//                         <button className="button" onClick={this.handleOnClick.bind(this)}>搜索</button>
//                     </div>
//                     <div>
//                         <Book booklist={bookList}></Book>
//                     </div>
//                 </form>
//             </div>
//         )
//     }
// }

// export default Inquiry;