import "./style.css";
import Chart from "chart.js/auto";

const ctx = document.getElementById("myChart");

new Chart(ctx, {
  type: "bar",
  data: {
    labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
    datasets: [
      {
        label: "# of Votes",
        data: [12, 19, 3, 5],
        borderWidth: 1,
      },
    ],
  },
  options: {
    scales: {
      y: {
        beginAtZero: true,
      },
    },
  },
});

const lineChartCtx = document.querySelector("#lineChart");

const xdata = ["01 / 02 / 2025", "02 / 02 / 2025", "03 / 02 / 2025"];
const ydata = [0, 10, 3];

const config = {
  type: "line",
  data: {
    labels: xdata,
    datasets: [
      {
        label: "Capteur 1",
        data: ydata,
      },
      {
        label: "Capteur 2",
        data: [-3, 20, 7],
      },
    ],
  },
};

const lineChart = new Chart(lineChartCtx, config);

const button = document.querySelector("#addRandomDataBtn");
button.addEventListener("click", () => {
  lineChart.data.labels.push("01 / 02 / 2025");
  for (const dataset of lineChart.data.datasets) {
    dataset.data.push(Math.random() * (40 + 10) - 10);
  }
  lineChart.update();
});
