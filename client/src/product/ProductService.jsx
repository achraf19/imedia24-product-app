import React from 'react';
import axios  from 'axios';

const PROD_SERVICE = 'localhost:8060/product'

class ProductService {

    fetchProducts() {
        axios.get(`${PROD_SERVICE}/all`)
    }
}

export default new ProductService()
 

