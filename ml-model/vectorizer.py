from sklearn.feature_extraction.text import TfidfVectorizer
import pickle

# Step 1: Train the vectorizer on your dataset
corpus = [
    "sample log text 1",
    "another log entry",
    "and so on..."
]
vectorizer = TfidfVectorizer()
vectorizer.fit(corpus)

# Step 2: Save the vectorizer
with open("vectorizer.pkl", "wb") as f:
    pickle.dump(vectorizer, f)
