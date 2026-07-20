import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css' 
import Home from './Components/Home'
import Contact from './Components/Contact'
import About from './Components/About'

function App() {
  return (
    <>
      <div className="container">
        <Home/>
        <Contact/>
        <About/>
      </div>
    </>
  )
}

export default App
