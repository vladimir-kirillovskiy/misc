# Python for Data Science Essentials
# This course is aimed at python 2.7 but I used 3.7

# DataFrame is like spread sheet with rows and columns always indexed
# Series is like array

import numpy as np
import pandas as pd

from pandas import Series, DataFrame

series_obj = Series(np.arange(8), index=['row 1', 'row 2', 'row 3', 'row 4', 'row 5', 'row 6', 'row 7', 'row 8'])

# label index
series_obj['row 7']


# integer index
# returns row 1 and row 8
series_obj[[0,7]]  # starts with 0

np.random.seed(25)
DF_obj = DataFrame(np.random.rand(36).reshape((6,6)), 
	index=['row 1', 'row 2', 'row 3', 'row 4', 'row 5', 'row 6'], columns=[...])
	
# ....




# k-neighbor classification
# usefull for Stock prediction, Recomendations systems, Credit Risk Analysis

# Assumptions:
# Dataset has little noise, labeled, only contains relevant features, has distinguishable subgroups

# Avoid using k-NN on large datasets. It will take a long time


# Network Analysis Use cases:
# Social media marketing strategy
# infrastructure system design
# Financial risk managment
# Public health managment

# Network - a body of connected data that's evaluated during graph analysis
# Graph - a data visualisation schematic depicting the data that comprises a network

# Graphs - Nodes, edges, Directed graph(digraph), Directed edges
# undirected graph, undirected edge, Graph size, graph order, degree

# Degree - node connectedness
# Successor - Node that could serve as backup and potentiall replace an influetial node in a network.
#   The dunction of a successor node is to preserve the flow of influence throughout a network in the case where an important node is removed

# Neighbors - are adjacent nodes in a network



# Basic Algirithmic Learning
# Linear Regression
# LR - is a statical machine learning method  you can use to quantify and make predictions based on relationships between numerical variables

# simple linear regression - one predictor and one predictant
# multiple linear regression - multiple predictors and one predictant

# use cases:
# Sales forcasting
# Resource consumption forcasting 
# Supply cost forcasting
# telecom services lifecycle forcasting

# assumptions:
# All variables are continuous numeric, not categorical
# Data is free of missing values and outliers
# There is a linear relationship between predictor and predictant
# All predictors are independent of each other
# Residuals (aka prediction errors) are normaly distributed

# Logistic Regression
# - is a simple machine learning method you can use to predict value of a numeric categorial variable based on its relationship with predictor variables.

# use cases:
# Purchase prospensity vs ad spend analysis
# Customer churn prediction
# Employee attrition modeling
# Hazardous event prediction

# assumptions:
# Data is free from missing values
# The predicant variable is binary (only accept two values) or ordinal (a categorical variable with ordered values)
# All predictors are independent from each other
# There are at least 50 observations per predictor variable (to ensure relieble results)


# Naive Bayes Classifiers
# - Method you can use to predict the likehood that an event will occur given evidence that's present in your data

# Conditional probability

#	P(B|A) = P(A and B)
#	------------------
#		P(A)


# tree types 
# multynominal - good fir when your features (categorical or continuous) describe discrete frequency counts(e.g. word counts) 
# Bernoulli - good for making predictions from binary features
# Gaussian - good for making predictions from normaly distributed features

# Use cases:
# Spam detection 
# Customer Classification
# Credit risk prediction
# Helth risk prediction

# Assumptions:
# predictions are independent of each other
# A priori assumption: This is an assumption that the past conditions still holds true. When we make predictions from historical values, 
# we will get incorrect results if present circumstances have changed.
# All regression models maintain an a priori assumption as well.



# Plotly for web-based data visualisation

# Python: NumPy, Pandas, matplotlib, Jupyter
# also works with R, Excel and SQL

# Cufflinks for Pandas in plotly
# Cufflinks is a library is useful for binding Plotly to Pandas objects whithin the Jupiter notebook

# Plotly attributes
# Traces: These are objects that describe a single variable of data in a graph, for example, a scatterplot or heatmap
# Layouts: You use these attributes to set layout elements for your plot, for example, the title, x-axis or annotations



# Web Scrapping with Beautiful soup
# Use cases:
# E-commerce Store Automation
# Hydrological Analysis
# Emergency Resource Allocation Planning
# Oil and Gas Production Intel

# Four Beautiful Soup Object types
# Beautiful soup object 
# Tag Object
# NavigableString object 
# Comment object




























