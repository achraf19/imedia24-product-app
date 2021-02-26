import React, { useEffect, useState } from 'react';
import axios from 'axios'

export function FetchRates() {

    const API_KEY = 'f681993022fb0d77336e02c975fe1c07'
    const FIXER_LATEST_RATE_API = `http://data.fixer.io/api/latest?access_key=${API_KEY}&base=USD&symbols=GBP,JPY,EUR`

    useEffect(() => {
        axios.get(FIXER_LATEST_RATE_API)
             .then(res => { return res.data } )
    }, [])

    
}

