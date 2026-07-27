import React from 'react'

const ListOfIndianPlayers = ({IndianPlayers}) => {
    return (
        <div>
            <li className = 'players-list'>
                {IndianPlayers.map((player, index) => (
                    <li key={index}>
                        Mr.{player}
                    </li>
                ))}
            </li>
        </div>
    )
}

export default ListOfIndianPlayers;