import "./App.css";
import CalculateScore from "./Components/scorecalculator";

function App() {
    return (
        <CalculateScore
            Name="Steven"
            School="ABC School"
            total={284}
            goal={300}
        />
    );
}

export default App;