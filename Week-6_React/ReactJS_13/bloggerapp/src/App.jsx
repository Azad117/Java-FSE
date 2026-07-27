import './App.css'
import CourseDetails from './CourseDetails'
import BookDetails from './BookDetails'
import BlogDetails from './BlogDetails'

function App() {

  const books = [
    { id : 101, name : "Master React",price : 500},
    { id : 102, name : "Deep Dive into Angular 11",price : 400},
    { id : 103, name : "Mongo Essentials",price : 300},
  ]

  const course = [
    { id : 1, name : "Angular", date : "2023-10-01" },
    { id : 2, name : "React", date : "2023-10-02" },
  ]

  const blog = [
    { id : 1, name : "React Learning" ,author : "Stephen Biz", cont : "Welcome to the world of React!" },
    { id : 2, name : "Angular Learning" ,author : "John Doe", cont : "Welcome to the world of Angular!" },
  ]

  return (
    <div className="App">
      <div className='content-wrapper'>
        <div className='v1'>
          <h1>Course Details</h1>
          <CourseDetails course={course}/>
        </div>
        
        <div className='st2'>
          <h1>Book Details</h1>
          <BookDetails books={books}/>
        </div>

        <div className='mystyle1'>
          <h1>Blog Details</h1>
          <BlogDetails blog={blog}/>
        </div>
      </div>
    </div>
  )
}

export default App
