# MyContactRecyclerViewTestApp

This is a simple Android application created to demonstrate how to implement `RecyclerView`. The project is designed for learning purposes and provides a basic understanding of setting up and using a `RecyclerView` in Android.

## Features

- Populates a list of names using a `RecyclerView`.
- Each item in the `RecyclerView` consists of a name and a message button.
- Demonstrates the use of `RecyclerView.Adapter`, `RecyclerView.ViewHolder`, and `DataClass`.

## Getting Started

### Prerequisites

- Android Studio
- Android SDK

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/Ace1032/AndroidFundamentals.git
    ```

2. Open the project in Android Studio.

3. Run the application on an emulator or physical device.

## Implementation Details

### DataClass

The `DataClass` represents the data model for the `RecyclerView` items.

```kotlin
data class DataClass(
    var name: String,
    var b_value: Boolean = false
)
