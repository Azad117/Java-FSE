import "../styleSheets/mystyle.css";

const percentToDecimal = (decimal) => {
    return decimal.toFixed(2) + "%";
};

const calcscore = (total, goal) => {
    return percentToDecimal((total / goal) * 100);
};

const CalculateScore = ({ Name, School, total, goal }) => (
    <div className="formalstyle">
        <h1 style={{ color: "brown" }}>Student Details</h1>

        <div className="Name">
            <b>Name:</b> {Name}
        </div>

        <div className="School">
            <b>School:</b> {School}
        </div>

        <div className="Total">
            <b>Total:</b> {total} Marks
        </div>

        <div className="Score">
            <b>Score:</b> {calcscore(total, goal)}
        </div>
    </div>
);

export default CalculateScore;