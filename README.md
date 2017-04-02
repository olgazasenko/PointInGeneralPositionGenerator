# PointInGeneralPositionGenerator

This program generates points in general position and writes them to a test file.
Points are represented as x and y coordinates. Each point can have a colour, hence
the generated points are split into colour groups.
In PointInGeneralPositionGenerator.java parameters k and n can be set, where k is the number
of colours, and n - the number of points in total. 
A file with generated points looks like the following:

k
n_1
x_11 y_11
x_12 y_12
...
n2
x_21 y_21
x_22 y_22
...
n_k
x_k1 y_k1
x_k2 y_k2
...

where n_1 + n_2 + ... + n_k = n.
