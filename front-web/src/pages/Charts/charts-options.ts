export const pieOptions = {
    chart: {
      background: "transparent",
      foreColor: "red",
    },
    colors: ["#6CA6CD", "#ed7947", "#00B2EE", "#EE9A00"],
    legend: {
      show: false,
    },
    tooltip: {
      enabled: true,
    },
    dataLabels: {
      enabled: true,
      offsetX: "100px",
      offsetY: "100px",
      style: {
        colors: ["#6CA6CD", "#ed7947", "#00B2EE", "##EE9A00"],
        fontSize: "20px",
        fontFamily: "Play, sans-serif",
        fontWeight: 700,
      },
    },
    plotOptions: {
      pie: {
        customScale: 0.7,
        expandOnClick: false,
        dataLabels: {
          offset: 60,
        },
      },
    },
  };
  
  export const barOptions = {
    chart: {
      toolbar: {
        show: false,
      },
    },
    colors: ["#ED7947"],
    grid: {
      show: false,
    },
    plotOptions: {
      bar: {
        horizontal: true,
        endingShape: "rounded",
        startingShape: "rounded",
        barHeight: "60px",
      },
    },
    dataLabels: {
      enabled: true,
    },
    tooltip: {
      enabled: false,
    },
    xaxis: {
      labels: {
        show: false,
      },
      axisBorder: {
        show: false,
      },
      axisTicks: {
        show: false,
      },
    },
    yaxis: [
      {
        labels: {
          maxWidth: 360,
          style: {
            colors: "#00D4FF",
            fontSize: "18px",
            fontFamily: "Play, sans-serif",
            fontWeight: 700,
          },
        },
      },
    ],
  };