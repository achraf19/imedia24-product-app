import React, { useEffect, useState } from 'react';
import BootstrapTable from 'react-bootstrap-table-next';
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom'
import Product from './ProductForm';
import PS  from './ProductService';


function Products()  {
    const [products, setProducts] = useState([])

    useEffect(() => {
        let mounted = true
        PS.fetchProducts().then(res => { if (mounted) { setProducts(res.data.json()) } } )
        return() => mounted = false

    }, [])
    
    const state = { 
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
                        <BootstrapTable striped hover keyField='id' data={ products } columns={ state.columns } />  
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
 
export default Products;