import React, { Component } from 'react';
import axios from 'axios'
import { productForm } from './ProductForm'

const PROD_SERVICE =  'http://localhost:8060'
const CAT_SERVICE =  'http://localhost:8060'

class ProductService {

    fetchProducts() { return axios.get(`${PROD_SERVICE}/product/all`)  }
    fetchCategories() { return axios.get(`${CAT_SERVICE}/category/all`)  }

    

}

export default new ProductService()