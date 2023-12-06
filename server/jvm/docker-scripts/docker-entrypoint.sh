#!/bin/bash
systemctl start postgresql-14
systemctl enable sshd.service
systemctl start sshd.service
su -c "startServer" - "position-app"
echo "Logged as position-app, starting server"
tail -f /dev/null