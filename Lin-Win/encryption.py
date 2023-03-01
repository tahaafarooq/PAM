"""
author : @tahaafarooq
file : encryption.py
desc : Encryption and Decryption functions.
"""

from cryptography.fernet import Fernet
from pathlib import Path
import platform
import os


class WriteCreds:
    def __init__(self, site, username, password):
        self.site = site
        self.username = username
        self.password = password

    # function to write the data to a temporary file
    def write_file(self):
        username = self.username
        password = self.password
        site = self.site

        if platform.system() == "Windows":
            user_path = Path.home()
            with open(f"{user_path}\Temp\creds.txt") as creds_file:
                text = f"{username} - {password} - {site}"
                creds_file.write(text)
        elif platform.system() == "Linux":
            pass


class EncryptCreds:
    def __init__(self, key):
        self.key = key

    # function to encrypt the files.
    def encrypt_file(self):
        key = self.key
        if platform.system() == "Windows":
            user_path = Path.home()
            tmp_file = f"{user_path}\Temp\creds.txt"
            out_file = f"{user_path}\Temp\output.txt"
            with open(tmp_file, "rb") as cred_file:
                original = cred_file.read()
            fernet = Fernet(key)
            encrypted = fernet.encrypt(original)
            with open(out_file, "wb") as enc_file:
                enc_file.write(encrypted)
                os.system(f"del {tmp_file}")
                return "Encrypted The Data"
        elif platform.system() == "Linux":
            pass

