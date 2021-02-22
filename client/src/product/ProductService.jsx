import React, { Component } from 'react';
import { axios } from 'axios';

const PROD_SERVICE = 'localhost:8060/product'

export function fetchProducts() {
    axios.get(PROD_SERVICE + '/all')
         .then(res => res.json())
}

export function addProduct(product) {
    axios.post(PROD_SERVICE + '/add', { product }).then(res => res.json())
}