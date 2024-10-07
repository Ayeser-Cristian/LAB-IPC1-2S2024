const MyApp = require('./app')

const port = 5000


MyApp.listen(port, ()=>{
    console.log(`The API is listening at http://localhost:${port}`); 
})