import React, { Component } from 'react';
// import ReactDOM from 'react-dom';
//import 'semantic-ui-css/semantic.min.css';
import Button from 'semantic-ui-react/dist/commonjs/elements/Button/Button';
import Input from 'semantic-ui-react/dist/commonjs/elements/Input/Input';
import Container from 'semantic-ui-react/dist/commonjs/elements/Container/Container';
import Header from 'semantic-ui-react/dist/commonjs/elements/Header/Header';
import NavBar from './NavBar';
import NavBarU from './NavBarUtil';
//import Image from 'semantic-ui-react/dist/commonjs/elements/Image/Image';
import {Quote} from './Quote'; 
import {getQuote, getImage, guid} from '../Utils' //name import
import List from 'semantic-ui-react/dist/commonjs/elements/List/List';
import { ButtonSimple } from './ButtonExampleEmphasis';
import { Quotes } from './Quotes';
import { Images } from './Images';
import { CenterQuoteImg } from './CenterQuoteImg';
// import 'whatwg-fetch'

const leftItems = [
    { as: "a", content: "Home", key: "home" },
    { as: "a", content: "Users", key: "users" }
  ];
const rightItems = [
    { as: "a", content: "Login", key: "login" },
    { as: "a", content: "Register", key: "register" }
  ];

const arr = ['Apples', 'Pears', 'Oranges'];

export default class QuoteApp extends Component{
    state = {
        quotes: [],
        images: [], 
        quoteImg:{
            /*quote:'One test quote',
            author:'Me!',
            image:'https://picsum.photos/200/200/?image=20'*/
        }, 
        quoteCenter:{}
    }

    handleClickQuote =(quote)=>{
        this.setState(()=>({quoteCenter: quote}))
        //console.log(quote);
    }
    handleQuote =()=>{

    }
    componentDidMount (){
        let count = 1;
        let quotes = [];
        let images = [];

        const jsonQuotes = JSON.parse(localStorage.getItem('quotes'));
        const jsonImages = JSON.parse(localStorage.getItem('images'));
        const jsonQuoteImg = JSON.parse(localStorage.getItem('quoteImg'));

        if (jsonQuotes && jsonImages) {
            this.setState(()=> ({quotes: jsonQuotes})) 
            this.setState(()=> ({images: jsonImages}))
            this.setState(()=> ({quoteImg: jsonQuoteImg}))
        } else {
            while (count <= 3 ){
                //console.log('while');
                getQuote( (response) => {
                    //se comporta diferente con la linea abajo
                    quotes.push({id: guid(), quote: response.quoteText, author: response.quoteAuthor});
                    //console.log(quotes, '----------');
                    //quotes.push(response.quoteText +'... Author: ' +response.quoteAuthor)
                    if (count = 3) {
                        //console.log('count quote: ', count);
                        this.setState((prevState)=> ({
                            quotes: quotes,/*prevState.quotes.concat(quote)*/ 
                            quoteImg:{
                                quote: response.quoteText,
                                author: response.quoteAuthor,
                                image:''
                            }
                        })) 
                        localStorage.setItem('quotes', JSON.stringify(this.state.quotes)); 
                        //localStorage.setItem('quoteImg', JSON.stringify(this.state.quoteImg)); 
                    }
                })

                getImage( (data)=>{
                    let img = data.url;
                    //console.log(count,images);
                    images.push(img);
                    if (count = 3) {
                        console.log('count img');
                        this.setState((prevState)=> ({ 
                            images: images,
                            quoteImg:{
                                quote: prevState.quoteImg.quote,
                                author: prevState.quoteImg.author,
                                image:img
                            }
                        }))  
                        localStorage.setItem('images', JSON.stringify(this.state.images)); 
                        localStorage.setItem('quoteImg', JSON.stringify(this.state.quoteImg)); 
                        //console.log(this.state.quoteImg, '1234')
                    }
                    
                });

                count++;
            }
        }
    }
    
     render(){
      return(
        <div>
        <NavBarU leftItems={leftItems} rightItems={rightItems}>
            <div>

                {/*************************LEFT SIDE*******************************/}
                <div className="leftSide">
                    <h4>Quote Side</h4>
                </div>
                <Container className="quoteSide">
                    <Quotes 
                        quotes={this.state.quotes}
                        handleClickQuote={this.handleClickQuote}
                    >
                    </Quotes>
                </Container>

                {/*************************CENTER SIDE*******************************/}
                <div className="centerSide">
                    <h4>Center Side</h4>
                </div>
                <Container className="centerSide">
                    {
                        //<Image src="https://react.semantic-ui.com/assets/images/wireframe/paragraph.png" />
                        /**<CenterQuoteImg img='https://picsum.photos/200/200/?image=20' quote='One test quote' author='Me!'/>  */
                    //  console.log(this.state.quoteImg, '...QuoteImgApp')
                    }
                    <CenterQuoteImg
                        quote={this.state.quoteImg}
                        //img='https://picsum.photos/200/200/?image=20'
                    /> 
                </Container>

                {/*************************RIGHT SIDE*******************************/}
                <div className="rightSide">
                    <h4>Image Side</h4>
                </div>
                <Container className="imageSide">
                    <Images images={this.state.images}>asdf</Images> 
                </Container>

            </div>
        </NavBarU>
    </div>
      )
  }
}
    