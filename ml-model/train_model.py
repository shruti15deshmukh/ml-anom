import pandas as pd
import numpy as np
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split
import pickle

# Simulate log data (or replace this with your actual CSV)
data = {
    'response_time': np.random.normal(loc=100, scale=30, size=200),
    'error_count': np.random.poisson(lam=2, size=200),
    'cpu_usage': np.random.uniform(10, 90, size=200),
    'memory_usage': np.random.uniform(30, 100, size=200),
    'disk_io': np.random.uniform(50, 300, size=200),
    'failure': np.random.choice([0, 1], size=200, p=[0.85, 0.15])  # 1 = failure
}

df = pd.DataFrame(data)

# Split data
X = df.drop("failure", axis=1)
y = df["failure"]

# Train/test split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Train model
clf = RandomForestClassifier(n_estimators=100, random_state=42)
clf.fit(X_train, y_train)

# Save model to disk
with open("model.pkl", "wb") as f:
    pickle.dump(clf, f)

print("✅ Model trained and saved as model.pkl")
