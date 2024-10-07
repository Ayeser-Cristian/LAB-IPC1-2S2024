
const express = require('express')
const cors = require('cors')
const bodyParser = require('body-parser');


const MyApp = express();

MyApp.use(bodyParser.json({ limit: '15mb' }));

MyApp.use(express.json()) 

MyApp.use(cors()) 

const MyRouter = require('./routers/router')

MyApp.use(MyRouter)

module.exports = MyApp