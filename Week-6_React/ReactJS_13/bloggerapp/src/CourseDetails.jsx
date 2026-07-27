import React from 'react';

const CourseDetails = (props) => {
    const content = (
            <ul>
                {props.course.map((course) =>
                    <div key={course.id}>
                        <h1>{course.name}</h1>
                        <p>{course.date}</p>
                    </div>
                )}
            </ul>
        );
    return (
        <div>
            {content}
        </div>
    );
}

export default CourseDetails;