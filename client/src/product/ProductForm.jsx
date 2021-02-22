import React, { Component, useState } from 'react';
import { useForm } from 'react-hook-form'


const onSubmitForm = (formData) => {
    console.log("the product name is" + formData.productName)
}


export function ProductForm() {

        const { nameInput, setName } = useState('')
        const { priceInput, setPrice } = useState('')
        const { quantityInput, setQt } = useState('')
        const { nameInput, setName } = useState('')
        const { nameInput, setName } = useState('')

        const { register, handleSubmit, errors, watch, formState } = useForm({
            mode: 'onTouched'
        })

        const { isValid, isSubmitting, isSubmitted, isSubmitSuccessful } = formState
        console.log(errors)
        
        return (
            
            <div className="productForm">
                {isSubmitSuccessful && <div className="alert alert-success">This product is added successfully !</div>}

                <h1>NEW PRODUCT</h1>
                <form onSubmit={handleSubmit(onSubmitForm)} style={{marginTop: 200}}>
                    <div className="form-row">
                        <div className="col-1" id="col">
                            <input type="text" className="form-control" name="productName" placeholder="product name"
                            ref= {register({ required: 'Product name is required !' })}/>
                            { errors.productName && <span>{ errors.productName.message }</span>}
                            <input type="text" className="form-control" id="num" name="price" placeholder="price" ref= {register({required: true})}/>

                            <select className="custom-select custom-select-sm" ref= {register}>
                                <option selected></option>
                                <option value="1">USD</option>
                                <option value="2">GBP</option>
                                <option value="3">MAD</option>
                            </select>

                        </div>
            
                    </div>

                    <div className="form-row" >
                        <div className="col-3" id="col">
                            <input type="text" className="form-control" id="num" name="quantity" placeholder="quantity" ref= {register({required: true})}/>

                            <select className="custom-select custom-select-sm" ref= {register}>
                                <option selected>Choose a category</option>
                                <option value="1">A</option>
                                <option value="2">B</option>
                                <option value="3">C</option>
                            </select>
                        </div>
                    </div>

                    <div className="form-row">
                        <div className="col-6">
                                <input type="text" className="form-control" name="desc" placeholder="specify a description of this product .." ref= {register({required: true})}/>
                            </div>
                    </div>
                    <div className="form-row">
                        <div className="col-7">
                            <input type="submit" id="submitProduct" value="ADD THIS PRODUCT !" disabled={!isValid}/>
                        </div>
                    </div>

                </form>
            </div>
            
        );
    
}

export default ProductForm
 
