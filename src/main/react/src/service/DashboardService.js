import Api from "./Api";

const dashboard = (update) => {
    Api.get("/dashboard")
        .then(response => {
            if (response.data) {
                update(response.data);
            }
        });
}


const DashboardService = {
    dashboard
}

export default DashboardService