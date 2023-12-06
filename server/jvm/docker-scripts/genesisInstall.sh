#!/bin/bash
source /home/position-app/.bashrc
systemctl start postgresql-14
su -c "source /home/position-app/.bashrc ; genesisInstall" - "position-app"
echo "genesisInstall done"