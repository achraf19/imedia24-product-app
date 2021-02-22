import React, { Component } from 'react';
import BootstrapTable from 'react-bootstrap-table-next';
import ProductService from './ProductService'
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom'
import Product from './ProductForm';


class Products extends Component {
    
    state = { 
        products:[],
        columns:[
            {
                dataField: 'id',  
                text: 'ID' 
            },
            {
                dataField: 'name',  
                text: 'Name' 
            },
            {
                dateFied: 'price',
                text: 'Price',
            },
            {
                dateFied: 'quantity',
                text: 'Quantity'
            },
            {
                dateFied: 'description',
                text: 'Description'
            },
            {
                dateFied: 'category',
                text: 'Category'
            }


        ]
        
    }

   
    componentDidMount() {
        ProductService.fetchProducts().then(res => { this.setState({ products:res.data })})
        
    }
     
    render() { 

        if(this.state.products.length == 0) return <h2>No products are available !</h2>  
       
        return ( 
            <div>
                
                <div className="wrapper" style={{ margin: 90 }}>
                    <h2 >Product List</h2> 
                    <Router>
                        <div className="container" style= {{ marginLeft: 537}}>
                            <Link className="navbar-brand" to={"/add-product"}>Add new product</Link>
                        </div>
                    </Router>
                    <div  >
                        <BootstrapTable striped hover keyField='id' data={ this.state.products } columns={ this.state.columns } />  
                    </div>  
                </div>

                <div className="Products">
                    <Switch>
                        <Route path= '/add-product' component= {Product}/>
                    </Switch>
                </div>
            </div>
        )
    }
    
}
 
export default Products;