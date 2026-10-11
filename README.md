# MS Courier Service

A courier booking app I built in Java using Swing. You sign up, log in, fill in the sender and receiver details, pay by card, and confirm with an OTP screen. There's also a small dashboard where you can add and remove parcels.

It was made as an OOP course project, so everything is stored in plain text files instead of a database. It works fine for learning, but it's not meant for real use.

## What it does

- Sign up with a username, password and email, then log in
- Send a parcel in four steps: sender details, receiver details, payment, OTP
- Dashboard to add a parcel (ID, quantity, weight) or remove one by ID
- Basic checks on the forms: empty fields, numbers-only fields, password confirmation
- Pickup and shipping areas cover Bangladesh's 8 divisions
- Product types to pick from: Electronics, Glass, Clothes, Metal, Antique Pieces, Jewellery

## How the screens connect

```
Welcome page -> Sign up / Login -> Home page
Home page -> Send Parcel: Sender -> Receiver -> Payment -> OTP
Home page -> Dashboard: add / remove parcels
```

## Folder layout

```
MS COURIER SERVICE/
  Start.java            starts the app
  CourierF/             Courier class (id, quantity, weight)
  CourierListF/         CourierList, an array that holds up to 100 couriers
  Data/                 CourierData.java for reading/writing, plus the .txt files
  frames/               all the Swing windows
  Image/                backgrounds and the Visa/Mastercard logos
```

## Running it

You need JDK 8 or newer. I developed it on Windows, and the code uses paths like `.\Image\login.jpg`, so it works best there.

Open a terminal inside the `MS COURIER SERVICE` folder and run:

```
javac Start.java CourierF/*.java CourierListF/*.java Data/*.java frames/*.java
java Start
```

Run it from that folder. If you start it from somewhere else, the images and data files won't be found.

## Things to know

- Passwords and card details are saved as plain text in the `Data` folder. Please don't enter real card info.
- The OTP screen is only a mock-up. It doesn't send or check a code.
- There's no real payment gateway behind the payment page.
- On Linux or Mac you'd have to change the `\` paths first.
- The `Data` folder has some test entries in it. Delete them before you use the app for real.

## Ideas for later

- Use a real database like SQLite or MySQL
- Hash the passwords and stop saving card details
- Send a real OTP by email or SMS
- Parcel tracking and delivery status
- Work out the delivery charge from weight and distance
- Switch to `File.separator` so it runs on any OS

## License

Not added yet. MIT is a good default if you want others to reuse it.
