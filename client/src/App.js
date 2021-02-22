import React from 'react';
import NavBar from "./NavBar";
import "bootstrap/dist/css/bootstrap.css";
import 'semantic-ui-css/semantic.min.css'
import { BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom'
import './App.css';
import Products from './product/Products';
import Categories from './category/Categories';
import Product from './product/ProductForm';


function App() {
  return (

    <Router>
      <nav className="navbar navbar-expand-lg navbar-light fixed-top" style= {{fontFamily: "RobotoMono-Regular"}}>
        <div className="container">
          <Link className="navbar-brand" to={"/sign-in"}>CODING CHALLENGE</Link>
          <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link className="nav-link" to={"/product-list"}>Products</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to={"/category-list"}>Categories</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <div className="App">
        <Switch>
        <Route exact path= '/' component= {Product}/>
        <Route path= '/product-list' component= {Products}/>
        <Route path= '/category-list' component= {Categories}/>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
