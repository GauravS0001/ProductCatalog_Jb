import requests
import time

URL = "http://localhost:8080/api/products/featured"
HEADERS = {"Content-Type": "application/json"}

def measure_response_time(num_requests=10):
    times = []
    for i in range(num_requests):
        start = time.time()
        response = requests.get(URL, headers=HEADERS)
        duration = (time.time() - start) * 1000  # in ms
        times.append(duration)
        print(f"Request {i+1}: {duration:.2f} ms")
    avg_time = sum(times) / len(times)
    return avg_time

def clear_cache():
    print("Clearing Redis cache manually...")
    refresh_url = "http://localhost:8080/api/products/featured/refresh"
    requests.post(refresh_url)

if __name__ == "__main__":
    print("Cold Start Benchmark (No Cache)")
    clear_cache()
    avg_cold = measure_response_time()

    print("\nWarm Cache Benchmark (With Redis)")
    avg_warm = measure_response_time()

    print("\nResults")
    print(f"Avg Cold Response Time: {avg_cold:.2f} ms")
    print(f"Avg Warm Response Time: {avg_warm:.2f} ms")
    improvement = ((avg_cold - avg_warm) / avg_cold) * 100
    print(f"Estimated Performance Gain: {improvement:.2f}%")
