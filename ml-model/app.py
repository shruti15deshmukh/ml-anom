from fastapi import FastAPI
from pydantic import BaseModel
import pickle

# Load model
with open("model.pkl", "rb") as mf:
    model = pickle.load(mf)

app = FastAPI()

# Define input schema
class LogData(BaseModel):
    response_time: float
    error_count: int
    cpu_usage: float
    memory_usage: float
    disk_io: float

@app.post("/predict")
async def predict(data: LogData):
    input_data = [[
        data.response_time,
        data.error_count,
        data.cpu_usage,
        data.memory_usage,
        data.disk_io
    ]]
    prediction = model.predict(input_data)[0]

    return {
        "prediction": int(prediction),
        "status": "anomaly detected" if prediction == 1 else "healthy"
    }
