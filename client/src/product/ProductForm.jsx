import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { FetchRates } from './FixerAPI' 



const ProductForm = () =>  {


        const PROD_SERVICE = 'http://localhost:8060/product'
        const [rates, setRates] = useState([])
        const [ product, setProduct ] = useState({
            name: '',
            price: '',
            currency: '',
            quantity: '',
            category: '',
            description: ''
        })
            
        const [ submitted, setSubmitted ] = useState(false)
        const [ valid, setValid ] = useState(false)

        

        
        const onSubmitForm = (e) => {
            e.preventDefault()
            if (product.name && product.price && product.currency && product.quantity && product.category && product.description) {
                setValid(true)
                axios.post(`${PROD_SERVICE}/add`, product).then(res => {
                    if (res.data != null) { 
                        setSubmitted(true) 
                        setTimeout(() => setSubmitted(false), 300) 
                    }
                    else { setSubmitted(false) }
                })

            }
            
            
        }
        
        
        return (
            
            <div className="productForm">
                {submitted && <div className="success-message">This product is added successfully !</div>}

                <h1>NEW PRODUCT</h1>
                <form onSubmit={onSubmitForm} style={{marginTop: 200}}>
                    <div className="form-row">
                        <div className="col-1" id="col">
                            <input type="text" className="form-control" name="name" placeholder="product name"
                            value={product.name} 
                            onChange={e => setProduct({ ...product, name: e.target.value })} />
                            
                            {submitted && !product.name && <span id='product-name-error'>Please enter a name of the product</span>}

                            <input type="text" className="form-control" id="num" name="price" placeholder="price" 
                            value={product.price} 
                            onChange={e => setProduct({ ...product, price: e.target.value })}/>
                            
                            
                            {submitted && !product.price && <span id='price-error'>Please enter a price</span>}

                            <select className="custom-select custom-select-sm"
                            name="currency" 
                            value={product.currency} 
                            onChange={e => setProduct({...product, currency: e.currentTarget.value })}
                            
                            >
                                {
                                    rates.map( rate => <option value={rate}>{rate}</option> )
                                }
                            </select>

                        </div>
            
                    </div>

                    <div className="form-row" >
                        <div className="col-3" id="col">
                            <input type="text" className="form-control" id="num" name="quantity" placeholder="quantity" 
                            value={product.quantity}
                            onChange={e => setProduct({ ...product, quantity: e.target.value }) }/>


                            {submitted && !product.quantity && <span id='quantity-error'>Please specify a quantity</span>}
                            <select className="custom-select custom-select-sm" 
                            name="product[category]" 
                            value={product.category} 
                            onChange={e => setProduct({...product, category: e.currentTarget.value })} >
                                <option selected>Choose a category</option>
                                <option value="1">A</option>
                                <option value="2">B</option>
                                <option value="3">C</option>
                            </select>
                        </div>
                    </div>

                    <div className="form-row">
                        <div className="col-6">
                                <input type="text" className="form-control" name="description" placeholder="specify a description of this product .." 
                                value={product.description}
                                onChange={e => setProduct({...product, description: e.target.value })}
                                />
                            </div>
                    </div>
                    <div className="form-row">
                        <div className="col-7">
                            <input type="submit" id="submitProduct" value="ADD THIS PRODUCT !"/>
                        </div>
                    </div>

                </form>
                
                
            </div>
            
        );
    
}

export default ProductForm
 
