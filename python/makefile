SHELL=bash

ifeq ($(OS),Windows_NT)
	SYSTEM_PYTHON=py -3.8
	VENV_HOME=./venv/Scripts
else
	SYSTEM_PYTHON=python3.8
	VENV_HOME=./venv/bin
endif


create-venv:
	$(SYSTEM_PYTHON) -m venv venv

install-dependencies:
	${VENV_HOME}/pip install -r requirements.txt

init-venv: create-venv install-dependencies

tests: init-venv
	${VENV_HOME}/python -m pytest test
