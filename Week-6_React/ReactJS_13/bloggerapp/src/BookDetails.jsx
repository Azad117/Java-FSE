import React from 'react';

const BookDetails = (props) => {
    const content = (
            <ul>
                {props.books.map((book) =>
                    <div key={book.id}>
                        <h3>{book.name}</h3>
                        <h4>{book.price}</h4>
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

export default BookDetails;