from flask import Flask, redirect, url_for, request, jsonify
import json
import RPi.GPIO as GPIO

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(3, GPIO.OUT)
GPIO.setup(5, GPIO.OUT)
GPIO.setup(7, GPIO.OUT)
GPIO.setup(11, GPIO.OUT)

print("Setting Up Pins")

GPIO.output(3, GPIO.LOW)
GPIO.output(5, GPIO.LOW)
GPIO.output(7, GPIO.LOW)
GPIO.setup(11, GPIO.OUT)

relay1Value = False
relay2Value = False
relay3Value = False
relay4Value = False
  
app = Flask(__name__)

#Relay 1 
@app.route('/relay1/on', methods=['PUT'])
def relay1On():
    global relay1Value
    relay1Value = True
    GPIO.output(3, GPIO.HIGH)
    
    return {"Command":"Success"}
    

@app.route('/relay1/off', methods=['PUT'])
def relay1Off():
    global relay1Value
    relay1Value = False
    GPIO.output(3, GPIO.LOW)
    
    return {"Command":"Success"}
    
@app.route('/relay1/toggle', methods=['PUT'])
def relay1Toggle():
	global relay1Value
	if relay1Value == True:
		relay1Value = False
		GPIO.output(3, GPIO.LOW)		
	else:
		relay1Value = True
		GPIO.output(3, GPIO.HIGH)		
	return {"Command":"Success"}

#Relay 2	
@app.route('/relay2/on', methods=['PUT'])
def relay2On():
    global relay2Value
    relay2Value = True
    GPIO.output(5, GPIO.HIGH)
    
    return {"Command":"Success"}
    

@app.route('/relay2/off', methods=['PUT'])
def relay2Off():
    global relay2Value
    relay2Value = False
    GPIO.output(5, GPIO.LOW)
    
    return {"Command":"Success"}
    
@app.route('/relay2/toggle', methods=['PUT'])
def relay2Toggle():
	global relay2Value
	if relay2Value == True:
		relay2Value = False
		GPIO.output(5, GPIO.LOW)		
	else:
		relay2Value = True
		GPIO.output(5, GPIO.HIGH)		
	
	return {"Command":"Success"}
	
#Relay 3
@app.route('/relay3/on', methods=['PUT'])
def relay3On():
    global relay3Value
    relay3Value = True
    GPIO.output(7, GPIO.HIGH)
    
    return {"Command":"Success"}
    

@app.route('/relay3/off', methods=['PUT'])
def relay3Off():
    global relay3Value
    relay3Value = False
    GPIO.output(7, GPIO.LOW)
    
    return {"Command":"Success"}
    
@app.route('/relay3/toggle', methods=['PUT'])
def relay3Toggle():
	global relay3Value
	if relay3Value == True:
		relay3Value = False
		GPIO.output(7, GPIO.LOW)		
	else:
		relay3Value = True
		GPIO.output(7, GPIO.HIGH)		
	
	return {"Command":"Success"}
	
#Relay 4
@app.route('/relay4/on', methods=['PUT'])
def relay4On():
    global relay4Value
    relay4Value = True
    GPIO.output(11, GPIO.HIGH)
    
    return {"Command":"Success"}
    

@app.route('/relay4/off', methods=['PUT'])
def relay40ff():
    global relay4Value
    relay4Value = False
    GPIO.output(11, GPIO.LOW)
    
    return {"Command":"Success"}
    
@app.route('/relay4/toggle', methods=['PUT'])
def relay4Toggle():
	global relay4Value
	if relay4Value == True:
		relay4Value = False
		GPIO.output(11, GPIO.LOW)		
	else:
		relay4Value = True
		GPIO.output(11, GPIO.HIGH)		
	
	return {"Command":"Success"}
	
@app.route('/relayData', methods=['GET'])
def getRelayData():
	global relay1Value
	global relay2Value
	global relay3Value
	global relay4Value
	
	return {
			"relay1" : relay1Value,
			"relay2" : relay2Value,
			"relay3" : relay3Value,
			"relay4" : relay4Value,
			
			}

app.run(host='0.0.0.0', port=5000)
